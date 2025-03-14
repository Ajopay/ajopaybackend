

package com.example.ajopay.service.Implement;

import com.example.ajopay.dto.Reponse.LoginResponse;
import com.example.ajopay.dto.Reponse.Response;
import com.example.ajopay.dto.RequestDto.EmailDetails;
import com.example.ajopay.dto.RequestDto.LoginDto;
import com.example.ajopay.dto.RequestDto.Request;
import com.example.ajopay.exception.UserNotFoundException;
import com.example.ajopay.model.Users;
import com.example.ajopay.repository.UserRepository;
import com.example.ajopay.service.EmailService;
import com.example.ajopay.service.JwtService;
import com.example.ajopay.service.UserService;
import com.example.ajopay.utils.AccountNumberGen;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplement implements UserService {
    private  static  final Logger log= LogManager.getLogger(String.valueOf(UserServiceImplement.class));

    private final UserRepository userRepository;
    private final EmailService emailService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationManager authenticationManager;
    private  final JwtService jwtService;

    public UserServiceImplement(UserRepository userRepository, EmailService emailService,
                                BCryptPasswordEncoder bCryptPasswordEncoder, AuthenticationManager authenticationManager,
                                JwtService jwtService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }


    @Override
    public Response Signup(Request request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            Response response=new Response();
            response.setMessage("Email Already Exists");
            return response;
        }
        log.info("\"service::about setting\"");
        Users user = new Users();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        user.setConfirmPassword(bCryptPasswordEncoder.encode(request.getConfirmpassword()));
        user.setAvailableBalance(0.00);
        user.setTotalBalance(0.00);
        user.setPhoneNumber(request.getPhoneNumber());
        user.setAccountNumber(AccountNumberGen.generateAccountNumber());


        Users createdUser = userRepository.save(user);
        log.info("User created");

        EmailDetails emailDetails= new EmailDetails();
        emailDetails.setRecipient(createdUser.getEmail());
        emailDetails.setSubject("Welcome  to AjoPay-Start Saving Smartly!");
        emailDetails.setMesageBody("Dear "+ createdUser.getFirstName() + "\n Thank you for signing up with Ajopay!"
                + "\uD83c\uDF89 We're excited to have you on board and help you manage your savings efficiently.\n With " +
                "AjoPay, you can: \n" +
                "✔ Save money with trusted groups \n" +
                "✔ Track your contributions easily\n" +
                "✔ Enjoy a seamless and secure experience \n this is your account number   "
                + createdUser.getAccountNumber() + " .If you have any questions , feel free to reply to this email\n" +
                "or contact our support team at support@ajopay.com \n" +
                "\n" +
                "Happy saving! \uD83D\uDE80\n" +
                "\n" +
                "Best regards,\n" +
                "The AjoPay Team");
        emailService.sendEmailAlert(emailDetails);

        return new Response("200 OK ",createdUser.getFirstName(),createdUser.getAccountNumber());}

    @Override
    public Users getUsersbyFirstName(String firstName) {
        return  userRepository.findByFirstName(firstName).orElseThrow(()->
                new UserNotFoundException("User with firstname " + firstName + " not found"));

    }

    @Override
    public Users getUsersbyAccount(String account) {
        return  userRepository.findByAccountNumber(account).orElseThrow(()->
                new UserNotFoundException("User with account " + account + " not found"));
    }
    @Override
    public Users getEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(()->
                new UserNotFoundException("User with " + email + " not found"));
    }
//    public Users createUser(Users users) {
//        Users users1 = new Users();
//        users1.setEmail(users.getEmail());
//        users1.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
//
//        return  userRepository.save(users1);
//    }

    @Override
    public LoginResponse verify(LoginDto loginDto) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(),
                        loginDto.getPassword())
        );
        if (authenticate.isAuthenticated()) {
            Users user = userRepository.findByEmail(loginDto.getEmail())
                    .orElseThrow(() -> new UserNotFoundException("user"));
            String jwtToken = jwtService.generateToken(loginDto);
            return new LoginResponse(user.getEmail(), jwtToken);
        } else {
            throw new UserNotFoundException("User not found");
        }

    }
    }


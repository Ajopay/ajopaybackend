package com.example.bank.service.Implement;

import com.example.bank.dto.request.RequestDto;
import com.example.bank.dto.response.ResponseDto;
import com.example.bank.model.User;
import com.example.bank.repository.UserRepository;
import com.example.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImp  implements UserService {
    @Autowired
    private UserRepository userRepository;

    public ResponseDto SignUp(RequestDto requestDto){
        User user = new User();
        user.setAccountNumber(requestDto.getAccountNumber());
        user.setFirstName(requestDto.getFirstName());
        user.setSurname(requestDto.getSurname());
        user.setEmailAddress(requestDto.getEmailAddress());
        user.setPassword(requestDto.getPassword());
        user.setReferralCode(requestDto.getReferralCode());
        user.setSupportCode(requestDto.getSupportCode());
        user.setConfirmPassword(requestDto.getConfirmPassword());
        user.setPhoneNumber(requestDto.getPhoneNumber());

        User createdUser = userRepository.save(user);

        return new ResponseDto( createdUser.getFirstName());


    }
}

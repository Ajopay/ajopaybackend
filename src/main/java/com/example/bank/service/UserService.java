package com.example.bank.service;

import com.example.bank.dto.request.RequestDto;
import com.example.bank.dto.response.ResponseDto;

public interface UserService {
    public ResponseDto SignUp(RequestDto requestDto)  ;
}

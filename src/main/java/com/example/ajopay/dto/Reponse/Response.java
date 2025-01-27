package com.example.ajopay.dto.Reponse;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor


    public class Response {
        private String firstName;

        public Response(String firstName) {
            this.firstName = firstName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
    }



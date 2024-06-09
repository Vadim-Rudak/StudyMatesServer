package org.example.bookfd.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Authoriz {
    private Boolean status;
    private String message;
    private UserMod userMod;
}

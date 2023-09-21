package org.example.bookfd.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.bookfd.domain.User;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Registration {
    private Boolean status_reg;
    private String message;
    private User user = null;
}
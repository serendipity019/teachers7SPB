package gr.aueb.cf.teacherapp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record UserInsertDTO(
        @NotEmpty(message = "Username is required")
        @Size(min=3, max = 20, message = "Username must be between 3 and 20 characters")
        String username,

        @NotEmpty(message = "Password is required")
        @Size(min=8, message = "Password must be at least 6 characters")
        String password,

        String role // assuming you want the user to select a role
) {
}

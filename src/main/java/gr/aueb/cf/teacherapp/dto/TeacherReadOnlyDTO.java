package gr.aueb.cf.teacherapp.dto;

import java.time.LocalDateTime;

public record TeacherReadOnlyDTO (
        Long id,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        String uuid,
        String firstname,
        String lastname,
        String vat,
        String region
) {
}

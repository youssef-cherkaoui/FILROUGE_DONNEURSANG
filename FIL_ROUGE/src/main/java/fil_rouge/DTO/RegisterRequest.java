package fil_rouge.DTO;

import fil_rouge.Enums.GroupSanguin;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String nom;
    private String email;
    private String motdepasse;
    private String telephone;
    @Enumerated(EnumType.STRING)
    private GroupSanguin groupSanguin;
}

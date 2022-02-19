package uz.bakhromjon.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.bakhromjon.dto.BaseAbstractDto;

/**
 * @author Bakhromjon Fri, 8:59 PM 2/18/2022
 */
@Setter
@Getter
public class UserUpdateDto extends BaseAbstractDto {
    private String username;
    private String email;
    private String avatar;


    @Builder
    public UserUpdateDto(Long id, String username, String password, String email, String avatar) {
        super(id);
        this.username = username;
        this.email = email;
        this.avatar = avatar;
    }
}

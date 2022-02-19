package uz.bakhromjon.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.checkerframework.common.aliasing.qual.NonLeaked;
import uz.bakhromjon.dto.BaseAbstractDto;

/**
 * @author Bakhromjon Fri, 9:36 PM 2/18/2022
 */
@Setter
@Getter
public class UserDto extends BaseAbstractDto {
    private String username;
    private String password;
    private String email;
    private String avatar;

    @Builder
    public UserDto(Long id, String username, String password, String email, String avatar) {
        super(id);
        this.username = username;
        this.password = password;
        this.email = email;
        this.avatar = avatar;
    }
}

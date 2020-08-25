package eas.com.vo;

import lombok.*;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Setter
@Getter
@ToString
public class DummyResponseVO {
    private String message;
}

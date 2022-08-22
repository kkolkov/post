package com.kolkov.post.dto;

import com.kolkov.post.model.DispatchType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDto {
    @NotBlank
    String customerName;

    @NotNull
    @Range(min = 100000, max = 999999)
    Integer customerIndex;

    @NotBlank
    String customerAddress;

    @NotNull
    DispatchType dispatchType;
}

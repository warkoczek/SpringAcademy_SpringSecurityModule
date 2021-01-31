package pl.warkoczewski.SpringAcademy_SpringSecurityModule.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HashingPair {
    private String key;
    private String value;
}

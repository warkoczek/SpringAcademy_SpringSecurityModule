package pl.warkoczewski.SpringAcademy_SpringSecurityModule.service;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncoderService implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return null;
    }
    @EventListener(ApplicationReadyEvent.class)
    public void getHashCode(){
        StringBuilder hashString = new StringBuilder();
        hashString.setLength(10);
        CharSequence charSequence = "a";
        char[] chars = charSequence.toString().toCharArray();
        for(char c : chars){
            hashString.append(c+=1);
        }

        System.out.println(hashString.toString());
    }


    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return false;
    }
}

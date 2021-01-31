package pl.warkoczewski.SpringAcademy_SpringSecurityModule.service;


import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.model.HashingPair;
import pl.warkoczewski.SpringAcademy_SpringSecurityModule.util.HashingData;

import java.util.*;
import java.util.stream.Collectors;



@Service
public class PasswordEncoderService implements PasswordEncoder {
    private final static String pass = "warkocz00";
    public List<HashingPair> createHashingPairList(){
        List<HashingPair> list = new ArrayList<>();
        createMapOfHashedSigns().forEach((key, value) -> list.add(
                new HashingPair(key, value)));
        return list;
    }
    public Map<String, String> createMapOfHashedSigns(){
        List<String> keys = HashingData.HASHING_SIGNS_LIST;
        List<String> values = shuffle();
        populate(keys, values).entrySet().forEach(System.out::println);
        return populate(keys, values);
    }
    public List<String> shuffle(){
        List<String> toShuffle = HashingData.TO_SHUFFLE;
        List<String> shuffledL = new ArrayList<>();
        int start = 0;
        int end = 4;
        while(end < 93) {
            shuffledL.addAll(toShuffle.subList(start, end).stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
            start += 4;
            end += 4;
        }
        shuffledL.forEach(System.out::println);
        return shuffledL;
        //reverse order of each subList
       /* List<String> subList1 = toShuffle.subList(0, 12).stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<String> subList2 = toShuffle.subList(12, 24).stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<String> subList3 = toShuffle.subList(24, 36).stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<String> subList4 = toShuffle.subList(36, 48).stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<String> subList5 = toShuffle.subList(48, 60).stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<String> subList6 = toShuffle.subList(60, 72).stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<String> subList7 = toShuffle.subList(72, 84).stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<String> subList8 = toShuffle.subList(84, 92).stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        //joining sublists adding sublist4 first
        List<String> shuffledList = Stream.of(subList1, subList2, subList3, subList4, subList5, subList6, subList7, subList8).flatMap(Collection::stream).collect(Collectors.toList());
        //shuffledList.forEach(System.out::println);
        //return shuffledList;*/
    }
    private Map<String, String> populate(List<String> keys, List<String> values){
        Map<String, String> hashedSigns = new HashMap<>();
        for(int i = 0; i < keys.size(); i++){
            hashedSigns.put(keys.get(i), values.get(i));
        }
        return hashedSigns;
    }
    @EventListener(ApplicationReadyEvent.class)
    @Override
    public String encode(CharSequence rawPassword) {
       List<HashingPair> hashingPairs = createHashingPairList();
        String rawPasswordString = rawPassword.toString();
        StringBuilder encodedPass = new StringBuilder();
        for(char ch : rawPasswordString.toCharArray()){
            hashingPairs.stream()
                    .filter(hashingPair -> hashingPair.getKey().equals(String.valueOf(ch)))
                    .map(hashingPair -> encodedPass.append(hashingPair.getValue()));
        }
        System.out.println(encodedPass.toString());
        return encodedPass.toString();
    }
    /*
    @EventListener(ApplicationReadyEvent.class)
    public void getHashCode() throws NoSuchAlgorithmException {
        StringBuilder hashString = new StringBuilder();
        String password = "admin123";

        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);

        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.reset();
        messageDigest.update(salt);
        messageDigest.update(password.getBytes());
        byte[] resultByteArray = messageDigest.digest();
        for (byte b : resultByteArray) {
            doHashing(hashString, b);
        }
        System.out.println(hashString.toString());
    }
    private void doHashing(StringBuilder hashString, byte b){
            hashString.append(String.format("%02x", b));
    }
    /*
    private int checkAndSetHashingSignAt(int numberOfIterations, int hashingSignAt) {
        if(isHashingSignAtBigger(hashingSignAt)){
            hashingSignAt = numberOfIterations;
        }
        return hashingSignAt;
    }

    private boolean isHashingSignAtBigger(int hashingSignAt){
        if(hashingSignAt > HashingData.HASHING_SIGNS_MAP.length()){
            return true;
        }
        return false;
    }*/


    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return false;
    }
}

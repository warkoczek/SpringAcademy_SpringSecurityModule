package pl.warkoczewski.SpringAcademy_SpringSecurityModule.util;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
 public final class HashingData {
    public final static List<String> HASHING_SIGNS_LIST = getHashingSignsList();
    public final static List<String> TO_SHUFFLE = Arrays.asList("!", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-"
     , ".", "/", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ":", ";", "<", "=", ">", "?", "@"
     , "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V"
     , "W", "X", "Y", "Z", "[", "]", "^", "_", "`", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m"
     , "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "{", "|", "}", "~");

    private static List<String> getHashingSignsList(){
        List<String> list = new ArrayList<>();
        list.add("!");
        list.add("#");
        list.add("$");
        list.add("%");
        list.add("&");
        list.add("'");
        list.add("(");
        list.add(")");
        list.add("*");
        list.add("+");
        list.add(",");
        list.add("-");
        list.add(".");
        list.add("/");
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add(":");
        list.add(";");
        list.add("<");
        list.add("=");
        list.add(">");
        list.add("?");
        list.add("@");
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        list.add("G");
        list.add("H");
        list.add("I");
        list.add("J");
        list.add("K");
        list.add("L");
        list.add("M");
        list.add("N");
        list.add("O");
        list.add("P");
        list.add("Q");
        list.add("R");
        list.add("S");
        list.add("T");
        list.add("U");
        list.add("V");
        list.add("W");
        list.add("X");
        list.add("Y");
        list.add("Z");
        list.add("[");
        list.add("]");
        list.add("^");
        list.add("_");
        list.add("`");
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        list.add("h");
        list.add("i");
        list.add("j");
        list.add("k");
        list.add("l");
        list.add("m");
        list.add("n");
        list.add("o");
        list.add("p");
        list.add("q");
        list.add("r");
        list.add("s");
        list.add("t");
        list.add("u");
        list.add("v");
        list.add("w");
        list.add("x");
        list.add("y");
        list.add("z");
        list.add("{");
        list.add("|");
        list.add("}");
        list.add("~");
        return list;
    }
 }

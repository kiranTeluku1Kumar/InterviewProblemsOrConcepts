package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * From this Examination I found that,"matcher.find" will behave same as "matcher.matches" when find is used with ^<<pattern>>$
 * if without ^$ find method try to see pattern matches with substring instead of whole string.
 *      This means if one of the substring matches the pattern then it will treat whole string as matched
 * Example emailPatternCheckWithFindNoStartEndDelimiters
 */
public class PatternMatcherExample {

    public static void main(String[] args) {
        String toBeMatched ="kiran.telukuntla@gmail.com";
        emailPatternCheckWithMatches(toBeMatched);
        emailPatternCheckWithFindWithDelimiters(toBeMatched="kiran.telukuntla@gmail.com some@some.com");
        emailPatternCheckWithFindWithoutDelimiters(toBeMatched="kiran.telukuntla@gmail.com some@some.com");
        emailPatternCheckWithFindWithoutDelimiters(toBeMatched="kiran.telukuntla@gmail.com some@some.com sfsldjfsl");
        isAllLetters(toBeMatched="kiran");
        isAllDigits(toBeMatched="9876543");
        isAllSpecialCharacters(toBeMatched="/-*+ \\.\\\n\t");
    }

    /**
     * not special Characters-->Under Score
     * Special Characters-->/-*+\. tab space new line
     * @param toBeMatched
     */
    private static void isAllSpecialCharacters(String toBeMatched) {
        System.out.println("isAllSpecialCharacters Input is::"+toBeMatched.hashCode());
        Pattern allLettersPattern = Pattern.compile("\\W+");// the "+" used out side [] brackets is to represent one or more times a character can occur from this character set
        Matcher allLettersMatcher = allLettersPattern.matcher(toBeMatched);
        System.out.println("isAllSpecialCharacters::"+allLettersMatcher.matches());
    }

    private static void isAllDigits(String toBeMatched) {
        System.out.println("isAllDigits Input is::"+toBeMatched.hashCode());
        Pattern allLettersPattern = Pattern.compile("\\d+");
        Matcher allLettersMatcher = allLettersPattern.matcher(toBeMatched);
        System.out.println("isAllDigits::"+allLettersMatcher.matches());
    }

    private static void isAllLetters(String toBeMatched) {
        System.out.println("isAllLetters Input is::"+toBeMatched.hashCode());
        Pattern allLettersPattern = Pattern.compile("[a-zA-Z]+");
        Matcher allLettersMatcher = allLettersPattern.matcher(toBeMatched);
        System.out.println("is All letters::"+allLettersMatcher.matches());
    }

    public static void emailPatternCheckWithMatches(String toBeMatched){
        System.out.println("emailPatternCheckWithMatches Input is::"+toBeMatched.hashCode());
        Pattern emailPattern = Pattern.compile("[a-zA-Z_+.-]+@[a-zA-Z]+.(com|net|org|co.in)");
        Matcher emailMatcher = emailPattern.matcher(toBeMatched);
        System.out.println("emailPatternCheckWithMatches::"+emailMatcher.matches());
    }

    public static void emailPatternCheckWithFindWithDelimiters(String toBeMatched){
        System.out.println("emailPatternCheckWithFind Input is::"+toBeMatched.hashCode());
        Pattern emailPattern = Pattern.compile("^[a-zA-Z_+.-]+@[a-zA-Z]+.(com|net|org|co.in)$");
        Matcher emailMatcher = emailPattern.matcher(toBeMatched);
        System.out.println("emailPatternCheckWithFind::"+emailMatcher.find());
    }

    public static void emailPatternCheckWithFindWithoutDelimiters(String toBeMatched){
        System.out.println("emailPatternCheckWithFindNoStartEndDelimiters Input is::"+toBeMatched.hashCode());
        Pattern emailPattern = Pattern.compile("[a-zA-Z_+.-]+@[a-zA-Z]+.(com|net|org|co.in)");
        Matcher emailMatcher = emailPattern.matcher(toBeMatched);
        System.out.println("emailPatternCheckWithFindNoStartEndDelimiters::"+emailMatcher.find());
    }

}

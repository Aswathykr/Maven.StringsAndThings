package io.zipcoder;


/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input){
        Integer countXY = 0;
        countXY = numberOfEndingchars(input,"y");
        countXY += numberOfEndingchars(input,"z");

        if(input.endsWith("y") || input.endsWith("z"))
            countXY++;
        return countXY;
    }
    public int numberOfEndingchars(String input, String checkStr){
        Integer countInput = 0;
        for(int count = 0; count < input.length() - 1; ){
            count = input.indexOf(checkStr, count);

            Character nextChar;

            if(count == -1)
                break;
            if(count < input.length() - 1) {
                nextChar = input.charAt(count + 1);
                if (!Character.isLetter(nextChar)) {
                    count += 2;
                    countInput++;
                } else {
                    count++;
                }
            }
        }
        return countInput;
    }
    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){
        base = base.replace(remove, "");
        return base;
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input){
        int isCount = noOfSubString(input, "is");
        int notCount = noOfSubString(input, "not");

        return isCount == notCount;
    }
    private int noOfSubString(String input, String subString) {
        int count = 0;
        for(int index = 0; index < input.length(); ){
            index = input.indexOf(subString, index);
            if(index == -1)
                break;
            else {
                index += subString.length();
                count++;
            }
        }
        return count;
    }
    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input){
        boolean isHappy = true;
        for(int index = 0; index < input.length(); ){
            index = input.indexOf("g", index);
            if(index == -1)
                break;
            if(index < input.length() - 1
                    && input.charAt(index -1) != 'g' &&
                    input.charAt(index  + 1) != 'g'){
                return false;
            }
            index++;
        }
        return true;
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){
        Integer count = 0;
        for(int index = 0; index < input.length()-2; index++){

            if( input.charAt(index) == input.charAt(index  + 1) &&
                    input.charAt(index) == input.charAt(index  + 2) ){
                count++;
            }

        }

        return count;
    }
}

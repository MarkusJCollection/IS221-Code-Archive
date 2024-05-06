public class CheckAndClean {
    /*
     * Simple class to check and validate data is what its suppose to be.
     * Also, to sanitize input (put a \ in front of any non-character items).
     * It is a collection of callable functions over a traditional class (library style).
     */

    // String to check for SPECIAL characters with .contains()
    private final String SPECIALS = "$!'\"\\=-+*&^%$#@~`.?:;,<>,{}[]()";







    /**
     * This takes a string and checks if any characters are in SPECIALS.
     * If they are it appends them with a leading "\" to escape them.
     * If not it just adds them back to the string.
     * The final string (with new escapes) is then returned to the user.
     *
     * @param toclean The string to sanitize (add escapes before special chars)
     * @return A new string that has escaped all special chars
     */
    public String sanitize(String toclean) {
        if(!toclean.isEmpty()){
            String first = toclean.substring(0,1);

            if(SPECIALS.contains(first)){
                return "\\"+first+sanitize(toclean.substring(1));
            }else{
                return first+sanitize(toclean.substring(1));
            }

        }else{
            return "";
        }
    }







    /**
     * Given a string we will check if it startswith (case-insensitive) another string.
     *
     * @param tocheck String we will check for a matching items at start
     * @param tomatch What we are matching the check to (yes, no, y, n, etc.)
     * @return true or false based on if it's matching or not.
     */
    public boolean checkMatching(String tocheck, String tomatch) {
       return tocheck.substring(0,tomatch.length()).equalsIgnoreCase(tomatch);
    }









    /**
     * Wrapper function that calls checkLength with a minlength of 1 (default value).
     * Checks if string is at or below the maxlength (and at least 1 in length).
     * @param tocheck String to check
     * @param maxlength The maximum length of the string.
     *                  If maximum length is set to 0 this will always return false.
     *                  Because a minimum length is not given - it's assumed to be 1.
     * @return true or false depending on if string is the correct length
     */
    public boolean checkLength(String tocheck, int maxlength) {
        return checkLength(tocheck, maxlength, 1);
    }










    /**
     * Wrapper function that calls checkLength with a minlength of 1 (default value).
     * Checks if string is at or below the maxlength and above the minimum length given.
     * @param tocheck String to check
     * @param maxlength The maximum length of the string.
     *                  If maximum length is set to 0 this will always return false.
     * @param minlength A minimum length to check against.
     * @return true or false depending on if string is the correct length
     */
    public boolean checkLength(String tocheck, int maxlength, int minlength) {
        if(tocheck.isEmpty() || tocheck.isBlank()){
            return false;
        }
        else if(maxlength>0&&minlength>0&&maxlength>=minlength){
            return (tocheck.length()>=minlength)&&(tocheck.length()<=maxlength);
        }else{
            return false;
        }
    }










}

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
    Suppose we abstract our file system by a string in the following manner:

    The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:

    dir
        subdir1
        subdir2
            file.ext
    The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.

    The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:

    dir
        subdir1
            file1.ext
            subsubdir1
        subdir2
            subsubdir2
                file2.ext

    The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an
    empty second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing
    a file file2.ext.

    We are interested in finding the longest (number of characters) absolute path to a file within our file system.
    For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and
    its length is 32 (not including the double quotes).

    Given a string representing the file system in the above format, return the length of the longest absolute
    path to file in the abstracted file system. If there is no file in the system, return 0.

    Note:
    The name of a file contains at least a . and an extension.
    The name of a directory or sub-directory will not contain a ..
    Time complexity required: O(n) where n is the size of the input string.

    Notice that a/aa/aaa/file1.txt is not the longest file path, if there is another path aaaaaaaaaaaaaaaaaaaaa/sth.png.
 */
public class Solution {

    /**
     * I find this solution.
     *
     * The point is, find the level by using level = String.lastIndexOf("\t") + 1
     *      and find dir/file name by String.substring(level)
     *
     * Create an String array 'path'. Use level as index to save the found dir/file names.
     *      if the name is dir, do nothing;
     *      if the name is file, traverse 'path' to last level and compose the full path.
     *
     *
     * @param input
     * @return
     */
    public int lengthLongestPath(String input) {
        if(input == null || input.length() == 0) {
            return 0;
        }

        int maxLen = 0;
        String[] strings = input.split("\n");
        String[] path = new String[strings.length];

        for(int i = 0; i < strings.length; i++) {
            int level = strings[i].lastIndexOf("\t") + 1;
            String s = strings[i].substring(level);
            path[level] = s;

            if(s.contains(".")) {
                String p = "";
                for(int j = 0; j <= level; j++) {
                    p = p + path[j] + "/";
                }

                maxLen = Math.max(maxLen, p.length() - 1);
            }
        }

        return maxLen;
    }
}

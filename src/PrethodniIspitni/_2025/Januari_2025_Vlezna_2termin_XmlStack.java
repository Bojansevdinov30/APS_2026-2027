package PrethodniIspitni._2025;

import dataStructures.LinkedStack;

import java.util.*;

/*
TRUE:
        18
        /begin{section}
/begin{text}
more text
/end{text}
/begin{subsection}
/begin{text}
text text
text text
/end{text}
/begin{subsubsection}
/begin{text}
text text
/end{text}
/end{subsubsection}
/begin{text}
text text
/end{text}
/end{subsection}
/end{section}

FALSE:
        4
        /begin{text}
text text
/end{text}
/end{section}
----------------
        7
        /begin{section}
/begin{subsubsection}
/begin{text}
text text
/end{text}
/end{subsubsection}
/end{section}
==================================================*/
public class Januari_2025_Vlezna_2termin_XmlStack {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        input.nextLine();

        LinkedStack<String> stack = new LinkedStack<>();

        boolean correct = true;

        for (int i = 0; i < n; i++) {

            String str = input.nextLine();

            if (str.contains("begin")) {

                String[] parts = str.split("\\{");
                String type = parts[1];

                // subsubsection must be inside subsection
                if (type.contains("subsubsection")) {

                    if (!stack.isEmpty() &&
                            stack.peek().contains("subsection")) {

                        stack.push(type);

                    } else {

                        correct = false;
                        break;
                    }

                }

                // text must be inside something
                else if (type.contains("text")) {

                    if (!stack.isEmpty()) {

                        stack.push(type);

                    } else {

                        correct = false;
                        break;
                    }

                }

                // section or subsection
                else {

                    stack.push(type);
                }

            } else if (str.contains("end")) {

                String[] parts = str.split("\\{");
                String type = parts[1];

                if (stack.isEmpty()) {

                    correct = false;
                    break;

                } else if (stack.peek().contains(type)) {

                    // Correct closing tag
                    stack.pop();

                } else {

                    // Wrong closing order
                    correct = false;
                    break;
                }
            }
        }

        // There must be no unclosed begin tags
        if (!stack.isEmpty()) {
            correct = false;
        }

        if (correct) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}



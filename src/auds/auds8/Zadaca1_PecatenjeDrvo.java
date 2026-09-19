package auds.auds8;

import dataStructures.SLLTree;
import dataStructures.Tree;

/*Да се напише метод за печатење на јазлите на
едно дрво. Секој јазел треба да биде испечатен во
еден ред, а пред да се испечати содржината на
јазелот треба да се вметнат онолку празни места
колку што е нивото на тој јазел.*/
public class Zadaca1_PecatenjeDrvo {
    public static void main(String[] args) {

        Tree.Node<String> a, b, c, d;

        SLLTree<String> t = new SLLTree<String>();

        t.makeRoot("C:");

        a = t.addChild(t.getRoot(), "Program files");
        b = t.addChild(a, "CodeBlocks");
        c = t.addChild(b, "codeblocks.dll");
        c = t.addChild(b, "codeblocks.exe");
        b = t.addChild(a, "Notepad++");
        c = t.addChild(b, "langs.xml");
        d = c;
        c = t.addChild(b, "readme.txt");
        c = t.addChild(b, "notepad++.exe");

        a = t.addChild(t.getRoot(), "Users");
        b = t.addChild(a, "Darko");
        c = t.addChild(b, "Desktop");
        c = t.addChild(b, "Downloads");
        c = t.addChild(b, "My Documents");
        c = t.addChild(b, "My Pictures");
        b = t.addChild(a, "Public");

        a = t.addChild(t.getRoot(), "Windows");
        b = t.addChild(a, "Media");

        t.printTree();
    }
}

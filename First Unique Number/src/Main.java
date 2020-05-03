public class Main {

    public static void main(String[] args) {
	    FirstUnique firstUnique = new FirstUnique(new int[]{2,3,5});
	    System.out.println(firstUnique.showFirstUnique());
	    firstUnique.add(5);
        System.out.println(firstUnique.showFirstUnique());
        firstUnique.add(2);
        System.out.println(firstUnique.showFirstUnique());
        firstUnique.add(3);
        System.out.println(firstUnique.showFirstUnique());

        FirstUnique firstUnique1 = new FirstUnique(new int[]{7,7,7,7,7,7});
        System.out.println(firstUnique1.showFirstUnique());
        firstUnique1.add(3);
        System.out.println(firstUnique1.showFirstUnique());
        firstUnique1.add(3);
        System.out.println(firstUnique1.showFirstUnique());
        firstUnique1.add(7);
        System.out.println(firstUnique1.showFirstUnique());
        firstUnique1.add(17);
        System.out.println(firstUnique1.showFirstUnique());

        FirstUnique firstUnique2 = new FirstUnique(new int[]{1});
        System.out.println(firstUnique2.showFirstUnique());
    }
}

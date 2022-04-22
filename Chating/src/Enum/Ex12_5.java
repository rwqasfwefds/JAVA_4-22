package Enum;

// ������ : ����� ����
// EAST : 0, SOUTH : 1, WEST : 2, NORTH : 3
enum Direction{EAST, SOUTH, WEST, NORTH};

public class Ex12_5 {
    public static void main(String[] args) {
        // ������ ���� 3����
        Direction d1 = Direction.EAST; // ����ϱ� ���� ����
        Direction d2 = Direction.valueOf("WEST"); // WEST
        Direction d3 = Enum.valueOf(Direction.class, "EAST"); // Direction �� ��ü�� ���������� Ŭ������ �Ǿ �̷��Ե� ����

        System.out.println("d1 = " + d1);
        System.out.println("d2 = " + d2);
        System.out.println("d3 = " + d3);

        // �������� "=="�� �� �԰ǿ�
        System.out.println("d1 == d2 ? " + (d1 == d2));
        System.out.println("d1 == d3 ? " + (d1 == d3));
        System.out.println("d1.equals(d3) ? " + d1.equals(d3));
        System.out.println("d1.compareTo(d3) ? " + (d1.compareTo(d3)));
        // (�������� ���) d1(0) - d2(2) = -2 �� ����
        // �Ϲ����� �� : ũ�� 1, ������ 0, ������ -1
        System.out.println("d1.compareTo(d2) ? " + (d1.compareTo(d2)));

        switch(d1){
            case EAST:
            System.out.println("The direction is EAST");
            break;
            case SOUTH:
            System.out.println("The direction is SOUTH");
            break;
            case WEST:
            System.out.println("The direction is WEST");
            break;
            case NORTH:
            System.out.println("The direction is NORTH");
            break;
            default:
            System.out.println("Invalid direction.");
        }

        // �������� �ڷ���� �迭�� ��ȯ(return)
        Direction[] dArr = Direction.values(); 

        // ���� for ��
        for(Direction d : dArr){
            // name() : �������� ����̸��� ��ȯ(����)
            // ordinal() : �������� ��� ������ ��ȯ
            System.out.printf("%s = %d%n", d.name(), d.ordinal());
        }
    }
}

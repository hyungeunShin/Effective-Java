package chapter02.item01;

public class Merit3 {
    public interface Shape {
        void draw();
    }

    static class Circle implements Shape {
        public void draw() {
            System.out.println("Drawing Circle");
        }
    }

    static class Rectangle implements Shape {
        public void draw() {
            System.out.println("Drawing Rectangle");
        }
    }

    public static class ShapeFactory {
        public static Shape newShape(String type) {
            if(type.equals("circle")) {
                return new Circle();
            } else if(type.equals("rectangle")) {
                return new Rectangle();
            }

            throw new IllegalArgumentException("Unknown shape type");
        }
    }
}

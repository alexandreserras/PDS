package ex2;
public enum Shape{
    SQUARE("Square"),RECTANGLE("Rectangle"), CIRCLE("Circle");
    private String custom;

        private Shape(String custom) {
            this.custom = custom;
        }

        public String getCustomString() {
            return custom;
        }
}
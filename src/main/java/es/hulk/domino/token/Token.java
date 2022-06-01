package es.hulk.domino.token;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class Token {

    private String name;

    @Override
    public String toString() {

        if (name.equalsIgnoreCase("0")) {
            return  "*******\n" +
                    "*     *\n" +
                    "*     *\n" +
                    "*******\n" +
                    "*     *\n" +
                    "*     *\n" +
                    "*******";
        }

        return "";
    }
}

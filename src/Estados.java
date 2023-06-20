import java.util.HashMap;

public enum Estados {
    PROGRAMA(new String[]{"programa", "VAR", "(", "DECLARACAO", ")", "{", "COMAND", "}"}),
    DECLARACAO(new String[]{"VAR", ":", "TYPE", ";"}),
    COMAND(new String[]{"IF", "RETURN"}),
    IF( new String[]{"if", "(", "EXP", ")", "{", "RETURN", "}", "else", "{", "RETURN", "}"}),
    EXP(new String[]{"VAR", "==", "0"}),
    RETURN(new String[]{"return", "VAR", ";"}),
    TYPE(new String[]{"int"}),
    VAR(new String[]{"abc"});

    private String[] transicoes;

    Estados(String[] transicoes) {
        this.transicoes = transicoes;
    }

    public String[] getTransicoes() {
        return transicoes;
    }

    public static boolean exists(String name) {
        for (Estados e : Estados.values()) {
            if (e.name().equals(name)) {
                return true;
            }
        }
        return false;
    }
}

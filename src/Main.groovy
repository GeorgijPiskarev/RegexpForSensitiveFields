class Main {
    static void main(String[] args) {
        def sensitiveFields = ["fullName", "surname"]

        StringBuilder builder = new StringBuilder()

        for (int i = 0; i < sensitiveFields.size(); i++) {
            if (i == 0) {
                builder.append(" - %replace(%m){'(\"" + sensitiveFields[i] + "\"\\s*:\\s*)\"([\\s\\S]*?)\"','\$1****'}")
                builder.insert(0, " - %replace(").append("){'(" + sensitiveFields[i] + "=)([\\s\\S]*?)[,|)]','\$1****'}")
            } else {
                builder.insert(0, " - %replace(").append("){'(\"" + sensitiveFields[i] + "\"\\s*:\\s*)\"([\\s\\S]*?)\"','\$1****'}")
                builder.insert(0, " - %replace(").append("){'(" + sensitiveFields[i] + "=)([\\s\\S]*?)[,|)]','\$1****'}")
            }
            if (i == sensitiveFields.size() - 1) {
                builder.append("%n")
            }
        }
        print(builder.toString())
    }

}

class Main {
    static void main(String[] args) {
        StringBuilder builder = new StringBuilder()
        def sensitiveFields = ["fullName", "cardNumber"]

        for (int i = 0; i < sensitiveFields.size(); i++) {
            if (i == 0) {
                builder.append(" - %replace(%m){'(\"" + sensitiveFields[i] + "\"\\s*:\\s*\".)([\\s\\S]*?)(.\")','\$1****\$3'}")
            } else {
                builder.insert(0, " - %replace(").append("){'(\"" + sensitiveFields[i] + "\"\\s*:\\s*\".)([\\s\\S]*?)(.\")','\$1****\$3'}")
            }
            builder.insert(0, " - %replace(").append("){'(" + sensitiveFields[i] + "=.)([\\s\\S]*?)(.[,|)])','\$1****\$3'}")
        }
        println(builder.toString())
    }
}

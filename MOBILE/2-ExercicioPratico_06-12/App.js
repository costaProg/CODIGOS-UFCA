import * as React from "react";
import { View, TextInput, Button, Text } from "react-native";

export default function App() {
  const [valor, setValor] = React.useState("");
  const [resultado, setResultado] = React.useState("");

  function primo() {
    cont = 0;
    if (parseInt(valor) < 2) {
      setResultado("Valor digitado não é primo");
      return;
    }
    for (i = 1; i <= parseInt(valor); i++) {
      if (parseInt(valor) % i == 0) {
        cont++;
      }
    }
    if (cont > 2) {
      setResultado("Valor digitado não é primo");
    } else {
      setResultado("Valor digitado é primo");
    }
  }

  return (
    <View>
      <Text>Valor</Text>
      <TextInput
        onChangeText={setValor}
        placeholder={"Digite um valor inteiro"}
      />
      <Button title="Primo" onPress={primo} />
      <Text>{resultado}</Text>
    </View>
  );
}

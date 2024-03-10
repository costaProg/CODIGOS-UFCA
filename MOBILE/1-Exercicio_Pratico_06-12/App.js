import * as React from "react";
import { View, TextInput, Button, Text } from "react-native";

export default function App() {
  const [valor1, setValor1] = React.useState("");
  const [valor2, setValor2] = React.useState("");
  const [resultado, setResultado] = React.useState("");
  return (
    <View>
      <Text>Valor 1</Text>
      <TextInput onChangeText={setValor1} />
      <Text>Valor 2</Text>
      <TextInput onChangeText={setValor2} />
      <Button
        title="Somar"
        color="#363636"
        onPress={() => {
          setResultado(parseFloat(valor1) + parseFloat(valor2));
        }}
      />
      <Button
        title="Subtrair"
        color="#4F4F4F"
        onPress={() => {
          setResultado(parseFloat(valor1) - parseFloat(valor2));
        }}
      />
      <Button
        title="Multiplicar"
        color="#696969"
        onPress={() => {
          setResultado(parseFloat(valor1) * parseFloat(valor2));
        }}
      />
      <Button
        title="Dividir"
        color="#808080"
        onPress={() => {
          setResultado(parseFloat(valor1) / parseFloat(valor2));
        }}
      />
      <Text>{resultado}</Text>
    </View>
  );
}

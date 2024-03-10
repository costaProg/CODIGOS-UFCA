import * as React from "react";
import { View, TextInput, Button, Text } from "react-native";

export default function app() {
  const [value1, setValue1] = React.useState("");
  const [value2, setValue2] = React.useState("");
  const [value3, setValue3] = React.useState("");
  const [result, setResult] = React.useState("");
  return (
    <View>
      <Text>Valor 1</Text>
      <TextInput onChangeText={setValue1} />
      <Text>Valor 2</Text>
      <TextInput onChangeText={setValue2} />
      <Text>Valor 3</Text>
      <TextInput onChangeText={setValue3} />
      <Button
        title={"Concatenar"}
        onPress={() => {
          setResult(value1 + value2 + value3);
        }}
      />
      <Button
        title={"Limpar"}
        onPress={() => {
          setResult("");
        }}
      />
      <Text>{result}</Text>
    </View>
  );
}

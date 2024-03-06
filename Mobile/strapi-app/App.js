import axios from "axios";
import * as React from "react";
import { StyleSheet, Text, View } from "react-native";
import { ScrollView, Button, TextInput } from "react-native-web";
axios.defaults.baseURL = "http://10.0.84.197:1337/api";

export default function App() {
  const [usuario, setUsuario] = React.useState("");
  const [senha, setSenha] = React.useState("");
  const [dados, setDados] = React.useState([]);
  const [jwt, setJwt] = React.useState("");
  return (
    <View style={styles.container}>
      <Text>Login</Text>
      <TextInput placeholder="Digite seu nome" onChangeText={setUsuario} />
      <TextInput
        placeholder="Digite sua senha"
        secureTextEntry={true}
        onChangeText={setSenha}
      />
      <Button
        title="Login"
        onPress={async () => {
          try {
            const response = await axios.post("/auth/local", {
              identifier: usuario,
              password: senha,
            });
            setJwt(response.data.jwt);
          } catch (error) {
            console.log(error);
            console.log("Usuário ou senha incorretos");
          }
        }}
      />
      <Button
        title="Consulta"
        onPress={async () => {
          const { data } = await axios.get("/informes", {
            headers: { Authorization: `Bearer ${jwt}` },
          });
          setDados(data.data);
        }}
      />
      <ScrollView>
        {dados.map((item) => (
          <text key={item.id}>{item.attributes.mensagem}</text>
        ))}
      </ScrollView>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#fff",
    alignItems: "center",
    justifyContent: "center",
  },
});

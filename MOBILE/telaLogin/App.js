import React from "react";
import { View, StyleSheet } from "react-native";
import { Text, TextInput, Button } from "react-native-paper";
import { createNativeStackNavigator } from "@react-navigation/native-stack";
import { NavigationContainer } from "@react-navigation/native";

function Principal({ navigation, route }): JSX.Element {
  return (
    <View style={styles.container}>
      <Text style={styles.text}>Bem-vindo à sua Página Principal!</Text>
      <Button
        mode="contained"
        onPress={() => navigation.navigate("Autenticacao")}
        style={styles.button}
      >
        Sair
      </Button>
    </View>
  );
}

function Autenticacao({ navigation }): JSX.Element {
  const [nome, setNome] = React.useState("");
  const [senha, setSenha] = React.useState("");

  return (
    <View style={styles.container}>
      <Text style={styles.texto}>Login</Text>
      <TextInput
        mode="outlined"
        label="Nome"
        placeholder="Digite seu nome"
        value={nome}
        onChangeText={(text) => setNome(text)}
      />
      <TextInput
        mode="outlined"
        label="Senha"
        placeholder="Digite sua senha"
        value={senha}
        onChangeText={(text) => setSenha(text)}
        secureTextEntry
      />
      <Button
        icon="login"
        mode="contained"
        onPress={() => {
          if (nome == "Lucas" && senha == "123") {
            navigation.navigate("Principal");
          }
        }}
      >
        Confirmar
      </Button>
    </View>
  );
}

const Stack = createNativeStackNavigator();

function App(): JSX.Element {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen
          name="Autenticacao"
          options={{ title: "Autenticacao" }}
          component={Autenticacao}
        />
        <Stack.Screen name="Principal" component={Principal} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}

export default App;

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
    backgroundColor: "seashell",
    padding: 20,
  },
  texto: {
    fontSize: 20,
    fontWeight: "bold",
    marginBottom: 10,
  },
});

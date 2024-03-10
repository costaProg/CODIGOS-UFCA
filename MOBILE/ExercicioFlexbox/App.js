import { View, StyleSheet, Text, Button } from "react-native";

export default function App() {
  return (
    <View style={styles.container}>
      <View style={styles.cabecalho}>
        <Text style={styles.texto}>Olá mundo</Text>
        <Button title="Pesquisar" />
      </View>

      <View style={styles.conteudo}>
        <Text style={styles.textoC}>Olá mundo</Text>
        <Text style={styles.textoC}>Olá mundo</Text>
        <Text style={styles.textoC}>Olá mundo</Text>
        <Text style={styles.textoC}>Olá mundo</Text>
        <Text style={styles.textoC}>Olá mundo</Text>
        <Text style={styles.textoC}>Olá mundo</Text>
      </View>

      <View style={styles.rodape}>
        <Text style={styles.textoR}>Copyleft, nenhum direito reservado!!</Text>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    flexDirection: "column",
    justifyContent: "center",
    backgroundColor: "lightcyan",
  },
  cabecalho: {
    flex: 1,
    flexDirection: "row",
    justifyContent: "center",
    alignItems: "center",
    backgroundColor: "blue",
  },
  conteudo: {
    flex: 5,
    flexDirection: "row",
    flexWrap: "wrap",
    alignContent: "flex-start",
    justifyContent: "center",
    backgroundColor: "green",
  },
  rodape: {
    flex: 1,
    justifyContent: "center",
    textAlign: "right",
    backgroundColor: "yellow",
  },
  texto: {
    fontSize: 20,
    fontWeight: "bold",
    margin: 10,
    padding: 10,
  },
  textoC: {
    fontSize: 18,
    fontWeight: "bold",
    margin: 10,
    backgroundColor: "white",
    padding: 25,
  },
  textoR: {
    fontSize: 14,
    fontWeight: "bold",
    margin: 10,
  },
});

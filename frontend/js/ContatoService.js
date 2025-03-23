export default class ContatoService {
  static baseUrl = "http://localhost:8080";

  static async findContatoById(contatoId) {
    return fetch(this.baseUrl + `/contatos/${contatoId}`).then((response) => {
      if (!response.ok) {
        throw new Error("Erro ao buscar os dados " + response.status);
      }
      return response.json();
    });
  }

  static async updateContato(clientId, contatoId, contactData) {
    const response = await fetch(
      this.baseUrl + `/contatos/update/${contatoId}`,
      {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(contactData),
      }
    );

    const result = await response.json();

    if (response.ok) {
      window.location.href = `../show.html?id=${clientId}`;
      return null;
    }

    return result;
  }

  static async saveContact(clientId, contactData) {
    const response = await fetch(
      this.baseUrl + `/clientes/${clientId}/contatos/save`,
      {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(contactData),
      }
    );
    const result = await response.json();

    if (response.ok) {
      window.location.href = `../show.html?id=${clientId}`;
    }

    return result;
  }

  static async deleteContact(clientId, contatoId) {
    fetch(this.baseUrl + `/contatos/remove/${contatoId}`, {
      method: "DELETE",
    }).then((response) => {
      if (!(response.status == 204)) {
        throw new Error("Erro ao buscar os dados " + response.status);
      }
    });
  }
}

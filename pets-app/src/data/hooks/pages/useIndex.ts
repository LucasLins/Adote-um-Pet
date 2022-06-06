import { AxiosError } from "axios";
import { useEffect, useState } from "react";
import { Pet } from "../../@types/Pet";
import { ApiService } from "../../services/ApiService";

export function useIndex() {
  const [petsList, setPetsList] = useState<Pet[]>([]),
    [selectedPet, setSelectedPet] = useState<Pet | null>(null),
    [email, setEmail] = useState(""),
    [amount, setAmount] = useState(""),
    [message, setMessage] = useState("");

  useEffect(() => {
    ApiService.get("/pets").then((response) => {
      setPetsList(response.data);
    });
  }, []);

  useEffect(() => {
    if (selectedPet === null) {
      clearForm();
    }
  }, [selectedPet]);

  function adopt() {
    if (selectedPet !== null) {
      if (validateAdoptData()) {
        ApiService.post("/adopt", {
          pet_id: selectedPet.id,
          email: email,
          amount: amount,
        })
          .then(() => {
            setSelectedPet(null);
            setMessage("Pet adotado com sucesso!");
          })
          .catch((error: AxiosError) => {
            setMessage(error.response?.data.message);
          });
      } else {
        setMessage("Por favor, preencha todos os campos corretamente.");
      }
    }
  }

  function validateAdoptData() {
    return email.length > 0 && amount.length > 0;
  }

  function clearForm() {
    setEmail("");
    setAmount("");
  }

  return {
    petsList,
    selectedPet,
    setSelectedPet,
    email,
    setEmail,
    amount,
    setAmount,
    message,
    setMessage,
    adopt,
  };
}

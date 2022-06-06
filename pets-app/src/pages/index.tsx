import {
  Button,
  Dialog,
  DialogActions,
  Grid,
  Snackbar,
  TextField,
} from "@mui/material";

import { useIndex } from "../data/hooks/pages/useIndex";
import List from "../ui/components/List/List";
import Title from "../ui/components/Title/Title";

import type { NextPage } from "next";
const Home: NextPage = () => {
  const {
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
  } = useIndex();

  return (
    <div>
      <Title
        title=""
        subtitle={
          <span>
            Com um pequeno valor mensal, você <br />
            <strong>pode adotar um pet virtualmente</strong>
          </span>
        }
      />

      <List pets={petsList} onSelect={(pet) => setSelectedPet(pet)} />

      <Dialog
        open={selectedPet !== null}
        fullWidth
        PaperProps={{ sx: { p: 5 } }}
        onClose={() => setSelectedPet(null)}
      >
        <Grid container spacing={2}>
          <Grid item xs={12}>
            <TextField
              label={"E-mail"}
              type={"email"}
              fullWidth
              value={email}
              onChange={(e) => setEmail(e.target.value)}
            />
          </Grid>
          <Grid item xs={12}>
            <TextField
              label={"Quantia por mês"}
              type={"number"}
              fullWidth
              value={amount}
              onChange={(e) => setAmount(e.target.value)}
            />
          </Grid>
        </Grid>
        <DialogActions sx={{ mt: 5 }}>
          <Button color={"secondary"} onClick={() => setSelectedPet(null)}>
            Cancelar
          </Button>
          <Button variant={"contained"} onClick={() => adopt()}>
            Confirmar adoção
          </Button>
        </DialogActions>
      </Dialog>

      <Snackbar
        open={message.length > 0}
        message={message}
        autoHideDuration={2500}
        onClose={() => setMessage("")}
      />
    </div>
  );
};

export default Home;

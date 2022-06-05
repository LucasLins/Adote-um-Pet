import { Button } from '@mui/material';

import { Pet } from '../../../data/@types/Pet';
import { TextService } from '../../../data/services/TextService';
import { Description, Info, ListItem, ListStyled, Name, Picture } from './List.style';

interface ListaProps {
  pets: Pet[];
}

export default function List(props: ListaProps) {
  const textLimit = 200;
  return (
    <ListStyled>
      {props.pets.map((pet) => (
        <ListItem key={pet.id}>
          <Picture src={pet.picture} alt={pet.name} />
          <Info>
            <Name>{pet.name}</Name>
            <Description>
              {TextService.limitText(pet.story, textLimit)}
            </Description>
            <Button variant="contained" fullWidth>
              Adotar {pet.name}
            </Button>
          </Info>
        </ListItem>
      ))}
    </ListStyled>
  );
}

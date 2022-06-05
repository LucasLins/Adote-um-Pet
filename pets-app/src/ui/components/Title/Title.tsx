import { Subtitle, TitleStyled } from './Title.style';

interface TitleProps {
    title: string;
    subtitle?: string | JSX.Element;
}

export default function Tittle(props: TitleProps) {
  return (
    <>
      <TitleStyled>{props.title}</TitleStyled>
      <Subtitle>{props.subtitle}</Subtitle>
    </>
  );
}

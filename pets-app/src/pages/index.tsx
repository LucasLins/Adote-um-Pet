import List from '../ui/components/List/List';
import Title from '../ui/components/Title/Title';

import type { NextPage } from "next";
const Home: NextPage = () => {
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

      <List
        pets={[
          {
            id: 1,
            name: "Valentina",
            story:
              "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quasi facere praesentium doloribus a unde aut similique, maxime impedit distinctio voluptates expedita dignissimos dicta exercitationem corporis est. Eveniet dolorem praesentium vitae.",
            picture:
              "https://www.rd.com/wp-content/uploads/2021/01/GettyImages-1175550351.jpg",
          },
          {
            id: 2,
            name: "Teca",
            story:
              "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quasi facere praesentium doloribus a unde aut similique, maxime impedit distinctio voluptates expedita dignissimos dicta exercitationem corporis est. Eveniet dolorem praesentium vitae.",
            picture:
              "https://images.unsplash.com/photo-1518791841217-8f162f1e1131?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60",
          },
        ]}
      />
    </div>
  );
};

export default Home;

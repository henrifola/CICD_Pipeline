
import { useQuery } from "react-query";
import axios from "axios";
import logo from './logo.svg';


const User = () => {
  const fetchUser = async () => {
    const { data } = await axios.get(`/pokemontype/Grass`);
    return data;
  };

  const { 
            isLoading,
            isSuccess,
           data: pokemonData
        } = useQuery<IPokemonT>("user",fetchUser);
        
        if (isLoading) {
          return <p>Loading...</p>;
        }
  if (isSuccess) console.log('success, pokemon list: ',  pokemonData?.pokemons)
  return (

    <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <div className="App-intro">
            <h2>Pokemon List</h2>
          
          </div>
        </header>
      </div>
  );
};
export default User;

type IPokemonT =  {
    id: number,
    name: string,
    pokemons: IPokemon[]
  }

type IPokemon = {
    id: number,
    name: string
}



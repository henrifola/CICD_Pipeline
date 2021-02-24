
import React from "react";
import { QueryClient, QueryClientProvider } from "react-query";
import User from "./PokemonType";
// Create a client
const queryClient = new QueryClient();
export default function App() {
  return (
    // Provide the client to your App
    <QueryClientProvider client={queryClient}>
      <User />
    </QueryClientProvider>
  );
}
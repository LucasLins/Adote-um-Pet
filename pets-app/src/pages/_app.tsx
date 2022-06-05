import "../ui/styles/globals.css";

import { ThemeProvider } from "@mui/material";

import Header from "../ui/components/Header/Header";
import tema from "../ui/themes/theme";

import type { AppProps } from "next/app";
function MyApp({ Component, pageProps }: AppProps) {
  return (
    <ThemeProvider theme={tema}>
      <Header />
      <Component {...pageProps} />
    </ThemeProvider>
  );
}

export default MyApp;

import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import './index.css';
import App from './App.jsx';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import About from './components/About.jsx';
import Contact from './components/Contact.jsx';
import Login from './components/login.jsx';
import Cart from './components/Cart.jsx';
import Home from './components/Home.jsx';
import ErrorPage from './components/ErrorPage.jsx';
import { productsLoader } from './components/Home.jsx';
import { contactAction } from './components/Contact.jsx';
import { ToastContainer, Bounce } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import ProductDetail from './components/ProductDetail.jsx';
const appRouter = createBrowserRouter([
  {
    path: '/',
    element: <App />,
    errorElement: <ErrorPage />,
    children: [
      {
        index: true,
        element: <Home />,
        loader: productsLoader,
      },
      {
        path: '/home',
        element: <Home />,
        loader: productsLoader,
      },
      {
        path: '/about',
        element: <About />,
      },
      {
        path: '/contact',
        element: <Contact />,
        action: contactAction,
      },
      {
        path: '/login',
        element: <Login />,
      },
      {
        path: '/cart',
        element: <Cart />,
      },
      {
        path: '/products/:productId',
        element: <ProductDetail />,
      },
    ],
  },
]);

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <RouterProvider router={appRouter} />
    <ToastContainer
      position="top-center"
      autoClose={3000}
      hideProgressBar={false}
      newestOnTop={false}
      draggable
      pauseOnHover
      theme={localStorage.getItem('theme') === 'dark' ? 'dark' : 'light'}
      transition={Bounce}
    />
  </StrictMode>,
);

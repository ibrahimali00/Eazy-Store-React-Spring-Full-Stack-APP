import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import './index.css';
import App from './App.jsx';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import About from './components/About.jsx';
import Contact from './components/Contact.jsx';
import Login, { loginAction } from './components/Login.jsx';
import Cart from './components/Cart.jsx';
import Home from './components/Home.jsx';
import ErrorPage from './components/ErrorPage.jsx';
import { productsLoader } from './components/Home.jsx';
import { contactAction } from './components/Contact.jsx';
import { ToastContainer, Bounce } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import ProductDetail from './components/ProductDetail.jsx';
import { CartContext, CartProvider } from './store/cart-context.jsx';
import { AuthProvider } from './store/auth-context.jsx';
import CheckoutForm from './components/CheckoutForm.jsx';
import ProtectedRoute from './components/ProtectedRoute.jsx';
import Profile, {
  profileAction,
  profileLoader,
} from './components/Profile.jsx';
import Orders from './components/Orders.jsx';
import AdminOrders from './components/admin/AdminOrders.jsx';
import Messages from './components/admin/Messages.jsx';
import Register, { registerAction } from './components/Register.jsx';

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
        action: loginAction,
      },
      {
        path: '/register',
        element: <Register />,
        action: registerAction,
      },
      {
        path: '/cart',
        element: <Cart />,
      },

      {
        path: '/products/:productId',
        element: <ProductDetail />,
      },
      {
        element: <ProtectedRoute />,
        children: [
          {
            path: '/checkout',
            element: <CheckoutForm />,
          },
          {
            path: '/profile',
            element: <Profile />,
            loader: profileLoader,
            action: profileAction,
            shouldRevalidate: ({ actionResult }) => !actionResult?.success,
          },
          {
            path: '/orders',
            element: <Orders />,
          },
          {
            path: '/admin/orders',
            element: <AdminOrders />,
          },
          {
            path: '/admin/messages',
            element: <Messages />,
          },
        ],
      },
    ],
  },
]);

const initialCartContext = {
  cart: [],
  setCart: () => {},
  addToCart: () => {
    console.log('product is added to cart');
  },
  removeFromCart: () => {},
  totalQuantity: 5,
};

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <AuthProvider>
      <CartProvider>
        <RouterProvider router={appRouter} />
      </CartProvider>
    </AuthProvider>
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

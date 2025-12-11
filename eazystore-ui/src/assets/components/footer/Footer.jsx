import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faHeart } from '@fortawesome/free-solid-svg-icons';
import './footet.css';

const Footer = () => {
  return (
    <footer className="footer">
      <p>
        Copyright &#169; <a href="#"> 2025 imaginary Company. </a>
        <span>
          <FontAwesomeIcon
            icon={faHeart}
            className="footer-icon"
            aria-hidden="true"
          />
        </span>{' '}
        All rights reserved.
      </p>
    </footer>
  );
};

export default Footer;

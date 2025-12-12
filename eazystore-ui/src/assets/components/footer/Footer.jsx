import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faHeart } from '@fortawesome/free-solid-svg-icons';
import styles from './footer.module.css';

const Footer = () => {
  return (
    <>
      <footer className={styles.footer}>
        <p>
          Copyright &#169; <a href="#"> 2025 imaginary Company. </a>
          <span>
            <FontAwesomeIcon
              icon={faHeart}
              className={styles['footer-icon']}
              aria-hidden="true"
            />
          </span>{' '}
          All rights reserved.
        </p>
      </footer>
    </>
  );
};

export default Footer;

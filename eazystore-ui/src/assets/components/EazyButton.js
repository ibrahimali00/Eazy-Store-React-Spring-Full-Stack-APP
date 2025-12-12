import styled from 'styled-components';

const EazyButton = styled.button`
  background-color: ${(pros) => (pros.$primary ? '#5b21b6' : 'black')};
  color: white;
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  display: block;
  margin: 0 auto;

  &:hover {
    background-color: blue;
  }

  &:focus {
    outline: 2px solid orange;
  }
`;

export default EazyButton;

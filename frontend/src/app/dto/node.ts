import { Dog } from "./dog";

export interface DogNode {
  value: Partial<Dog>;
  mother?: DogNode;
  father?: DogNode;
}

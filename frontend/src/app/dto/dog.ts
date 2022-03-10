export interface Dog {
  id?: number;
  name: string;
  description?: string;
  birthdate: Date;
  gender: Gender;
}

type Gender = "MALE" | "FEMALE";

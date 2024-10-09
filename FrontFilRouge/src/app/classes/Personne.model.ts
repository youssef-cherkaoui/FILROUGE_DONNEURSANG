import {Role} from "./enums/Role/role";
import {GroupSanguin} from "./enums/GroupSanguin/groupSanguin";

export interface Personne {
  id: number;
  nom: string;
  email: string;
  motdepasse: string;
  telephone: string;
  groupSanguin: GroupSanguin;
  role: Role;
}

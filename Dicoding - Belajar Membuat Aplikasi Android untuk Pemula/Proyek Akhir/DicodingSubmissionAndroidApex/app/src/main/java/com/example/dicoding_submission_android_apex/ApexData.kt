package com.example.dicoding_submission_android_apex

object ApexData {

    private val apexNames = arrayOf(
        "Bangalore",
        "Bloodhound",
        "Caustic",
        "Fuse",
        "Octane",
        "Pathfinder",
        "Rampart",
        "Revenant",
        "Wattson"
    )

    private val apexGender = arrayOf(
        "Female",
        "Unknown",
        "Male",
        "Male",
        "Male",
        "Robot",
        "Female",
        "Robot",
        "Female"
    )

    private val apexAge = arrayOf(
        "40", "40", "50", "55", "26", "77", "23", "359", "24"
    )

    private val apexHomeworld = arrayOf(
        "Gridiron", "Talos", "Gaea", "Salvo", "Psamathe", "Psamathe", "Gaea", "Unknwon", "Solace"
    )

    private val apexClass = arrayOf(
        "Assault",
        "Recon",
        "Controller",
        "Assault",
        "Skirmisher",
        "Skirmisher",
        "Controller",
        "Skirmisher",
        "Controller"
    )

    private val apexTactical = arrayOf(
        "Smoke Launcher",
        "Eye of the Allfather",
        "Nox Gas Trap",
        "Knuckle Cluster",
        "Stim",
        "Grappling Hook",
        "Amped Cover",
        "Shadow Pounce",
        "Perimeter Security"
    )

    private val apexPassive = arrayOf(
        "Double Time",
        "Tracker",
        "Nox Vision",
        "Grenadier",
        "Swift Mend",
        "Insider Knowledge",
        "Modded Loader",
        "Assassin's Instinct",
        "Spark of Genius"
    )

    private val apexUltimate = arrayOf(
        "Rolling Thunder",
        "Beast of the Hunt",
        "Nox Gas Grenade",
        "The Motherlode",
        "Launch Pad",
        "Zipline Gun",
        "Mobile Minigun Sheila",
        "Forged Shadows",
        "Interception Pylon"
    )

    private val apexTacticalDescription = arrayOf(
        "Fire a high-velocity smoke canister that explodes into a smoke wall on impact.",
        "Briefly reveal enemies, traps, and clues through all structures in front of you",
        "Place up to 6 canisters that release deadly Nox gas when shot or triggered by enemies",
        "Launch a cluster bomb that continuously expels airburst explosives on impact",
        "Increase walk speed by 30% and sprint speed by 40% for 6 seconds. Costs Health to use. Reduction to slows while active",
        "Grapple to get to out-of-reach places quickly",
        "Build a crouch-cover wall, which deploys a full-cover amped wall that blocks incoming shots and amps outgoing shots. (Max: 5)",
        "Unleash a powerful pounce forwards. Hold to charge for further distance.",
        "Create electrified fences by connecting nodes. Fences damage and slow enemies."
    )

    private val apexPassiveDescription = arrayOf(
        "Taking fire while sprinting makes you move faster for a brief time",
        "Foes leave behind clues for you to find. White Ravens may appear to guide you to battle and charge your abilities",
        "You gain threat vision on enemies moving through your gas",
        "Stack an extra grenade per inventory slot. Fire grenades farther, faster, and more accurately",
        "Automatically restores health over time",
        "Scan a Care Package to reduce the cooldown of Zipline Gun",
        "Increased magazine/heat capacity and faster reloads/recharge when using LMGs and the Minigun",
        "Highlights nearby visible enemies that are low on health. You crouch walk faster and have improved wall climbing.",
        "Ultimate Accelerants fully charge Wattson's ultimate and she can carry more Ultimate Accelerants. Wattson slowly restores her shields over time."
    )

    private val apexUltimateDescription = arrayOf(
        "Call in an artillery strike that slowly creeps across the landscape",
        "Transform into the ultimate hunter. Launches a White Raven and enhances senses to see cold tracks and move faster. Knockdowns extend duration",
        "Blankets a large area in Nox gas",
        "Launch a bombardment that encircles a target in a wall of flame",
        "Deploy a jump pad that catapults anyone through the air. Press the jump button to double jump.",
        "Create a zipline for everyone to use",
        "Wield a mobile minigun with a single high capacity magazine. Place it down for anyone to use as a stationary and reloadable turret (Max: 3)",
        "Forge a shroud of hardened shadows around you that block damage and regenerate. Your shadows and tactical are refreshed on knockdowns.",
        "Place an electrified pylon that destroys incoming ordnance and repairs damaged shields. Standing near Pylons boosts Wattson's tactical recharge rate. (Max: 1)"
    )

    private val apexPhotoProfile = intArrayOf(
        R.drawable.bangalore,
        R.drawable.bloodhunt,
        R.drawable.caustic,
        R.drawable.fuse,
        R.drawable.octane,
        R.drawable.pathfinder,
        R.drawable.rampart,
        R.drawable.revenant,
        R.drawable.wattson
    )

    private val apexPhotoCover = intArrayOf(
        R.drawable.bangalore2,
        R.drawable.bloodhunt2,
        R.drawable.caustic2,
        R.drawable.fuse2,
        R.drawable.octane2,
        R.drawable.pathfinder2,
        R.drawable.rampart2,
        R.drawable.revenant2,
        R.drawable.wattson2
    )

    private val apexIconTactical = intArrayOf(
        R.drawable.bangaloretactical,
        R.drawable.bloodhunttactical,
        R.drawable.caustictactical,
        R.drawable.fusetactical,
        R.drawable.octanetactical,
        R.drawable.pathfindertactical,
        R.drawable.ramparttactical,
        R.drawable.revenanttactical,
        R.drawable.wattsontactical
    )

    private val apexIconPassive = intArrayOf(
        R.drawable.bangalorepassive,
        R.drawable.bloodhuntpassive,
        R.drawable.causticpassive,
        R.drawable.fusepassive,
        R.drawable.octanepassive,
        R.drawable.pathfinderpassive,
        R.drawable.rampartpassive,
        R.drawable.revenantpassive,
        R.drawable.wattsonpassive
    )

    private val apexIconUltimate = intArrayOf(
        R.drawable.bangaloreultimate,
        R.drawable.bloodhuntultimate,
        R.drawable.causticultimate,
        R.drawable.fuseultimate,
        R.drawable.octaneultimate,
        R.drawable.pathfinderultimate,
        R.drawable.rampartultimate,
        R.drawable.revenantultimate,
        R.drawable.wattsonultimate
    )

    private val apexIconClass = intArrayOf(
        R.drawable.assault_class,
        R.drawable.recon_class,
        R.drawable.controller_class,
        R.drawable.assault_class,
        R.drawable.skirmisher_class,
        R.drawable.skirmisher_class,
        R.drawable.controller_class,
        R.drawable.skirmisher_class,
        R.drawable.controller_class
    )



    val listData : ArrayList<ApexChar>
        get() {
            val list = arrayListOf<ApexChar>()
            for (position in apexNames.indices){
                val data = ApexChar()
                data.name = apexNames[position]
                data.gender = apexGender[position]
                data.age = apexAge[position]
                data.homeworld = apexHomeworld[position]
                data.classtype = apexClass[position]
                data.tacticalability = apexTactical[position]
                data.passiveability = apexPassive[position]
                data.ultimateability = apexUltimate[position]
                data.tacticaldescription = apexTacticalDescription[position]
                data.passivedescription = apexPassiveDescription[position]
                data.ultimatedescription = apexUltimateDescription[position]
                data.photoprofile = apexPhotoProfile[position]
                data.photocover = apexPhotoCover[position]
                data.icontactical = apexIconTactical[position]
                data.iconpassive = apexIconPassive[position]
                data.iconultimate = apexIconUltimate[position]
                data.iconclass = apexIconClass[position]
                list.add(data)
            }
            return list
        }
}
